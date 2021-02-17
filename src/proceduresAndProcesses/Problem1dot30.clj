(ns proceduresAndProcesses.Problem1dot30)

(defn sum
  [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(defn sum-iter
  [term a next b]
  (defn iter
    [a result]
    (if (> a b)
      result
      (iter (next a) (+ result (term a)))))
  (iter a 0))

(defn cube
  [x]
  (* x x x))

(defn -main
  [& args]
  (println (sum-iter cube 0 inc 100)))