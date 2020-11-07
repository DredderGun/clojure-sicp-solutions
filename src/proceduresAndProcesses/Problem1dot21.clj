(ns proceduresAndProcesses.Problem1dot21
  (:require [clojure.test :refer [is]]))

(defn square
  [a]
  (* a a))

(defn find-divisor
  [a n]
  (cond
    (= (mod a n) 0) n
    (>= (square n) a) a
    :else (find-divisor a (inc n))))

(defn smallest-divisor
  [a]
  (find-divisor a 2))

(defn -main
  [& args]
  (is (= 199 (smallest-divisor 199)) "Incorrect answer for 199")
  (is (= 1999 (smallest-divisor 1999)) "Incorrect answer for 1999")
  (is (= 7 (smallest-divisor 19999)) "Incorrect answer for 19999"))