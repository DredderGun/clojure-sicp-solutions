(ns proceduresAndProcesses.Problem1dot11
  (:require [clojure.test :refer [is]]))

(defn f [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    (= n 2) 2
    :else (+ (f (- n 1))
             (* 2 (f (- n 2)))
             (* 3 (f (- n 3))))))

(defn -main
  [& args]
  (is (= 4 (f 3)))
  (is (= 25 (f 5))))
