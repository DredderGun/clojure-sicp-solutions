(ns proceduresAndProcesses.Problem1dot9)

(defn recursive-fact
  [x]
  (if (not= x 1)
    (* x (recursive-fact (- x 1)))
    1))

(defn iterative-fact
  [x counter]
  (if (not= x 1)
    (iterative-fact (dec x) (* counter x))
    counter))

(defn -main
  [& args]
  (println (iterative-fact 24 1)))