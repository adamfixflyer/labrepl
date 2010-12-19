(ns student.minmax)

; my attempt, which worked first try!
(defn minmax-1
  [x & more]
  (loop [min x
         max x
         [x & more] (seq more)] ;binds x & more to the sequence more
    (if x
      (recur 
        (if (< x min) x min) 
        (if (> x max) x max) 
        more)
      (zipmap [:min :max] [min max]))))

; reduce is: f (val) coll
; my attempt, does not compile
;(defn minmax-2
;  [more]
;  (reduce
    ; first arg is always a map, second is always a new 'x'
;    (fn [result [x & more]
;      ({:min (if (< x (result :min)) x (result :min))
;       :max (if (> x (result :max)) x (result :max))
;       }))
;    {} 
;    (seq more)))
  
(defn minmax-2
  [x & more]
  (reduce
    (fn [result x]
      (->> result
        (merge-with min {:min x})
        (merge-with max {:max x})))
    {:min x :max x}
    more))
