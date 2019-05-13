(ns eight-queens.core
  (:require [clojure.set :refer [difference]]))

(defn- all-pos [size]
  (->>
   (for [x (range size)
         y (range size)] [x y])
   (into #{})))

(defn- attack-positions [x y size]
  (->>
   (concat (for [xp (range size)] [xp y])
           (for [yp (range size)] [x yp])
           (for [xp (range size)
                 yp (range size) :when (or (= (+ xp yp) (+ x y)) (= (- xp yp) (- x y)))] [xp yp]))
   (into #{})))

(defn- queens [valid-positions size x]
  (cond (= size x) 1
        (empty? valid-positions) 0
        :else  (let [place-pos (for [yp (range size) :when (valid-positions [x yp])] [x yp])]
                 (transduce
                  (map (fn [[x y]]
                         (queens
                          (difference valid-positions (attack-positions x y size))
                          size
                          (inc x)))) + 0 place-pos))))

(defn n-queens [n]
  (queens (all-pos n) n 0))

(defn eight-queens []
  (n-queens 8))
