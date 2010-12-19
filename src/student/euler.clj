(ns student.euler)

(defn divides?
  [dividend divisor]
  (zero? (rem dividend divisor)))

;my example
(defn divides-any-my
  [& nums]
  (fn [arg]
    (boolean
      (some ;except some takes 'pred coll'
        (map divides? nums)))))

(defn divides-any
  "Return a predicate that tests whether its arg can be
  evenly divided by any of nums."
  [& nums]
  (fn [arg]
    (boolean (some #(divides? arg %) nums))))

; my attempt, returns 0 for (euler-recur1 1000)
(defn euler-recur1
  [upper]
  (let [divisible? (divides-any 3 5)]
    (loop [sum 0 n 1]
      (if (>= n upper)
        (if (divisible? n)
          (recur (+ sum n) (inc n))
          (recur (sum) (inc n)))
        sum))))

(defn euler-recur
  "Sums the numbers divisible by 3 or 5, from 0 to upper."
  ([]
    (euler-recur 1000))
  ([upper]
    (let [divisible? (divides-any 3 5)]
      (loop [sum 0 n 1]
        (if (>= n upper)
              sum
              (recur
                (if (divisible? n) (+ sum n) sum)
                (inc n)))))))

(defn euler-reduce
  ([upper]
    (apply
      +
      (filter
        (divides-any 3 5)
        (range upper)))))

(defn lazy-euler1
  ([]
    (lazy-euler1 3 5))
  ([m3 m5]
    (lazy-seq
      (cons (min m3 m5)
        (if (= m3 m5)
          (lazy-euler1 (+ 3 m3) (+ 5 m5))
          (if (< m3 m5)
            (lazy-euler1 (+ 3 m3) m5)
            (lazy-euler1 m3 (+ 5 m5))))))))

      ;recurse with the unincremented value


