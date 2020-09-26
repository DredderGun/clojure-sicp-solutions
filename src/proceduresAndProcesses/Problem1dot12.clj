(ns proceduresAndProcesses.Problem1dot12
  (:require [clojure.test :refer [is]]))

(defn pascal-triangle [a b]
  (cond
    (= b 1) 1
    (= a b) 1
    (> b a) (pascal-triangle a a)
    :else (+ (pascal-triangle (- a 1) (- b 1))
       (pascal-triangle (- a 1) b))))

(defn -main
  [& args]
  (is (= 1 (pascal-triangle 1 1)) "Incorrect answer for row 1 and col 1")
  (is (= 1 (pascal-triangle 2 2)) "Incorrect answer for row 2 and col 2")
  (is (= 2 (pascal-triangle 3 2)) "Incorrect answer for row 3 and col 2")
  (is (= 3 (pascal-triangle 4 3)) "Incorrect answer for row 4 and col 3"))