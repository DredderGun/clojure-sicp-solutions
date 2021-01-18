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
        (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
        :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test
  [n]
  (defn try-it
    [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

; fast variant
(defn fast-prime?
  [n startTime times]
  (cond (= times 0) (do
                      (report-prime n startTime)
                      true)
        (fermat-test n) (fast-prime? n startTime (- times 1))
        :else false))

; slow variant
(defn prime?
  [n startTime]
  (cond (= (smallest-divisor n) n) (do (report-prime n startTime)
                                     true)
        :else false))

(defn iter
  [n start-time found-count]
  (cond
    (= found-count 5)
          (do)
    (prime? n (. System (nanoTime)))
          (iter (+ n 2) start-time (inc found-count))
    :else (iter (+ n 2) start-time found-count)))

(defn timed-prime-test
  [n]
  (iter n (. System (nanoTime)) 0))

(defn -main
  [& args]
  (timed-prime-test 1000000001) ; significant diff between fast-prime? and prime?
  (timed-prime-test 100001) ; small diff between fast-prime? and prime?
  )