(ns proceduresAndProcesses.Problem1dot22-24
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

(defn expmod
  [base exp m]
  (cond (= exp 0) 1
        (even? exp) (rem
                      (square (expmod base (/ exp 2) m))
                      m)
        :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test
  [n]
  (defn try-it
    [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (long (rand (- n 1))))))

; fast variant
(defn fast-prime?
  [n startTime times]
  (cond (= times 0) (do
                      (report-prime n startTime)
                      true)
        (fermat-test n) (fast-prime? n startTime (dec times))
        :else (do
                (println " Not a prime " n)
                false)))

; slow variant
(defn prime?
  [n startTime]
  (cond (= (smallest-divisor n) n) (do (report-prime n startTime)
                                     true)
        :else false))

(defn -main
  [& args]
  ;(fast-prime? 470344009939751483 (. System (nanoTime)) 5)
  (prime? 470344009939751483 (. System (nanoTime)))
  )