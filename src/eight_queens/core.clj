(ns eight-queens.core
  (:require [clojure.set :refer [difference]]))

(defn all-pos [size]
  (->>
   (for [x (range size)
         y (range size)] [x y])
   (into #{})))

(defn attack-positions [x y size]
  (into #{}
        (concat (for [xp (range size)] [xp y])
                (for [yp (range size)] [x yp])
                (for [xp (range size)
                      yp (range size) :when (or (= (+ xp yp) (+ x y))  (= (- xp yp) (- x y)))] [xp yp])

                )))

(defn queens [valid-positions size x]
  (cond (= size x) 1
        (empty? valid-positions) 0
        :else  (let [place-pos (for [yp (range size) :when (valid-positions [x yp])] [x yp])]
                 (reduce + 0
                         (map (fn [[x y]]
                                (queens
                                 (difference valid-positions (attack-positions x y size))
                                 size
                                 (inc x))) place-pos)))))

(defn eight-queens []
  (queens (all-pos 8) 8 0))
