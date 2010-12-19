(ns student.looping)

;(defn find-min [nums]
;  (let [min (first nums)
;        more (rest nums)]
;    (if-let [x] [])))

(defn min-1
  [x & more] ;args, destructured?
  (loop [min x
         more (seq more)] ; loop binding min -> x, more -> seq more 
    (if-let [x (first more)] ; bind x to first, if (x) ... 
      (recur (if (< x min) x min) (next more)) ; recur (loop) with smaller of x, min and (next more)
      min ))) ; else return min

(defn min-2
  [x & more]
  (loop [min x
         [x & more] (seq more)] ;don't really understand this 
    (if x ;if x exists
      (recur (if (< x min) x min) more) ;return (the less of x and min), and more
      min))) ;else return min


(defn lessanon [x y]
  (if (< x y) x y))

; my attempt (works)
(defn min-3
  [x & more]
  (reduce #(if (< %1 %2) %1 %2) 
    (cons x more))) 

; canonical
(defn min-3x
  [& coll]
  (reduce
    (fn [x y] (if (< x y) x y))
    coll))

(defn zipm-1
  [keys vals]
  (loop [m {}
         ks (seq keys)
         vs (seq vals)] ;why must do (seq keys) ?
    (if (and ks vs)
      (recur (assoc m (first ks) (first vs))
        (next ks)
        (next vs))
      m)))

(defn zipm-2
  [keys vals]
  ; binding => binding-form init-expr
  (loop [m {}
         [k & ks :as keys] (seq keys) ; binding-form is [k & ks :as keys], init-expr is (seq keys)
         [v & vs :as vals] (seq vals)]
    (if (and keys vals)
      (recur (assoc m k v) ks vs)
      m)))

(defn zipm-3
  [keys vals]
  ;usage: reduce f coll
  (reduce
    (fn [m [k v]] (assoc m k v)) ; fn takes args 1=map, 2=vector of [k v]
    {} (map vector keys vals)))
  
(defn zipm-4
  [keys vals]
  ;http://stackoverflow.com/questions/1257028/why-should-i-use-apply-in-clojure
  (apply hash-map (interleave keys vals)))

(defn zipm-5
  [keys vals]
  (into {} (map vector keys vals)))
