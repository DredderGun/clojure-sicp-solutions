(ns proceduresAndProcesses.Problem1dot29)

(defn cube
  [a]
  (* a a a))

(defn sum
  [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(defn simpson-integral
  [f a b n]
  (let [h (/ (- b a) n)
        yk (fn [k] (f (+ a (* h k))))
        simpson-term (fn [k] (* (cond (or (= k 0) (= k n)) 1
                                 (even? k) 4
                                 :else 2)
                                (yk k)))]
    (* (/ h 3) (sum simpson-term 0 inc n))))

(defn -main
  [& args]
  (println (double (simpson-integral cube 0 1 100)))
  (println (double (simpson-integral cube 0 1 1000))))