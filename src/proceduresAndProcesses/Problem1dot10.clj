(ns proceduresAndProcesses.Problem1dot10)

(defn accerman-fun [x y]
  (cond
    (= y 0) 0
    (= x 0) (* 2 y)
    (= y 1) 2
    :default (accerman-fun (- x 1) (accerman-fun x (- y 1)))))

(defn -main
  [& args]
  (println (accerman-fun 2 2)))