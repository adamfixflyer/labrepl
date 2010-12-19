(ns student.euler2)

(defn lazy-seq-fibo
  ([]
    (concat [0 1] (lazy-seq-fibo 0 1)))
  ([a b]
    (let [n (+ a b)]
      (lazy-seq
        (cons n (lazy-seq-fibo b n))))))

(defn finish?
  [n]
    (< n 4000000))

; these last 2 work on the repl, but won't load
; for some reason

(defn euler2-seq
  (take-while
    finish?
    (lazy-seq-fibo)))

(defn euler2
  (apply + (filter even? euler2-seq)))