(ns elementsOfProgramming.Problem1dot7
  (:require [clojure.test :refer [is]]))

(defn average
  [x y]
  (float (/ (+ x y) 2)))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn good-enough?
  [prev-guess new-guess]
  (= (/ prev-guess new-guess) 1.0))

(defn sqrt-iter [guess x]
  (if (good-enough? guess (improve guess x))
    guess
    (sqrt-iter (improve guess x) x)))

(defn improved-sqrt-iter
  [x]
  (sqrt-iter 1 x))

(defn -main
  [& args]
  (is (= 2.0 (improved-sqrt-iter 4)) "Incorrect answer for 4")
  (is (= 4.0 (improved-sqrt-iter 16)) "Incorrect answer for 16")
  (is (= 40000.0 (improved-sqrt-iter 1600000000)) "Incorrect answer for 1600000000")
  (is (= 7.4161983 (improved-sqrt-iter 55)) "Incorrect answer for 55")
  ; todo can`t compare two floats correct
  (is (= 0.0004 (improved-sqrt-iter 0.00000016)) "Incorrect answer for 0.00000016"))

