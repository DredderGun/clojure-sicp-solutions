(ns proceduresAndProcesses.Problem1dot16
  (:require [clojure.test :refer [is]]))

(defn square [a]
  (* a a))

(defn fast-iter-exponential
  [product power multiply-it-at-end]
  (cond
    (= power 1) (* product multiply-it-at-end)
    (even? power) (fast-iter-exponential (square product) (/ power 2) multiply-it-at-end)
    :else (fast-iter-exponential (square product) (/ (dec power) 2) (* product multiply-it-at-end))))

(defn fast-exponential
  [base power]
  (fast-iter-exponential base power 1))

(defn -main
  [& args]
  (is (= 4 (fast-exponential 2 2)) "Incorrect answer for power of 2")
  (is (= 2 (fast-exponential 2 1)) "Incorrect answer for 1")
  (is (= 64 (fast-exponential 2 6)) "Incorrect answer for 6")
  (is (= 128 (fast-exponential 2 7)) "Incorrect answer for 7")
  (is (= 256 (fast-exponential 2 8)) "Incorrect answer for 8")
  (is (= 1024 (fast-exponential 2 10)) "Incorrect answer for 10")
  (is (= 27 (fast-exponential 3 3)) "Incorrect answer for 3 3"))