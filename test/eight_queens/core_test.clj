(ns eight-queens.core-test
  (:require [clojure.test :refer :all]
            [eight-queens.core :refer :all]))

(deftest a-test
  (is (= 92 (eight-queens)))
  (is (= 724 (n-queens 10))))
