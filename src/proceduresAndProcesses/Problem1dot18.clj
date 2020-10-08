(ns proceduresAndProcesses.Problem1dot18
  (:require [clojure.test :refer [is]]))

(defn double
  [a]
  (+ a a))

(defn halve
  [a]
  (/ a 2))

(defn iter-fast-multiplication
  [a b]
  (defn process-iter
    [a b sum-it-at-end]
    (if (= b 0)
      0
      (if (= b 1)
        (+ a sum-it-at-end)
        (if (even? b)
          (process-iter (double a) (halve b) sum-it-at-end)
          (process-iter a (dec b) (+ sum-it-at-end a))))))
  (process-iter a b 0))

(defn -main
  [& args]
  (is (= 5 (iter-fast-multiplication 1 5)) "Incorrect answer for power of 1*5")
  (is (= 4 (iter-fast-multiplication 2 2)) "Incorrect answer for power of 2*2")
  (is (= 24 (iter-fast-multiplication 6 4)) "Incorrect answer for power of 6*4")
  (is (= 1 (iter-fast-multiplication 1 1)) "Incorrect answer for power of 1*1")
  (is (= 0 (iter-fast-multiplication 0 1)) "Incorrect answer for power of 0*1")
  (is (= 0 (iter-fast-multiplication 1 0)) "Incorrect answer for power of 1*0")
  (is (= 35 (iter-fast-multiplication 5 7)) "Incorrect answer for power of 5*7")
  (is (= 72 (iter-fast-multiplication 8 9)) "Incorrect answer for power of 8*9")
  (is (= 5000 (iter-fast-multiplication 500 10)) "Incorrect answer for power of 8*9"))