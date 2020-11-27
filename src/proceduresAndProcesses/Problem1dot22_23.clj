(ns proceduresAndProcesses.Problem1dot22-23
  (:require [clojure.test :refer [is]]))

; check for smallest divisor functions

(defn square
  [a]
  (* a a))

(defn next
  [n]
  (if (even? n)
    (inc n)
    (+ 2 n)))

(defn find-divisor
  [a n]
  (cond
    (> (square n) a) a
    (= (mod a n) 0) n
    :else (find-divisor a (next n))))

(defn smallest-divisor
  [a]
  (find-divisor a 2))

; end

(defn report-prime
  [n time-from]
  (println " *** ")
  (println " prime number: " n)
  (println (- (. System (nanoTime)) time-from)))

(defn prime?
  [n]
  (= (smallest-divisor n) n))

(defn iter
  [n start-time found-count]
  (cond
    (= found-count 3) found-count
    (prime? n) (do
                 (report-prime n start-time)
                 (iter (+ n 2) start-time (inc found-count)))
    :else (iter (+ n 2) start-time found-count)))

(defn timed-prime-test
  [n]
  (if (even? n)
    (do (report-prime n (. System (nanoTime)))
        (iter (inc n) (. System (nanoTime)) 1))
    (iter n (. System (nanoTime)) 0)))

(defn -main
  [& args]
  (timed-prime-test 1000000001)
  (timed-prime-test 10000000001)
  (timed-prime-test 100000000001)
  (timed-prime-test 1000000000001))