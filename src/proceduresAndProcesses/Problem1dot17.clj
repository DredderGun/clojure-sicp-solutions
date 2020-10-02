(ns proceduresAndProcesses.Problem1dot17
  (:require [clojure.test :refer [is]]))

(defn double
  [a]
  (+ a a))

(defn halve
  [a]
  (/ a 2))

(defn fast-multiplication
  [a b]
  (if (= b 0)
    0
    (if (even? b)
      (double (fast-multiplication a (halve b)))
      (+ (double (fast-multiplication a (halve (dec b))))
         a))))

(defn -main
  [& args]
  (is (= 4 (fast-multiplication 2 2)) "Incorrect answer for power of 2")
  (is (= 2 (fast-multiplication 2 1)) "Incorrect answer for 1")
  (is (= 12 (fast-multiplication 2 6)) "Incorrect answer for 6")
  (is (= 20 (fast-multiplication 2 10)) "Incorrect answer for 10"))