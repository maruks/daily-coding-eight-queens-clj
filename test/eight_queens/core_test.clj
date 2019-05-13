(ns eight-queens.core-test
  (:require [clojure.test :refer :all]
            [eight-queens.core :refer :all]))

(deftest n-queens-test
  (is (= 2 (n-queens 4)))
  (is (= 10 (n-queens 5)))
  (is (= 4 (n-queens 6)))
  (is (= 40 (n-queens 7)))
  (is (= 92 (eight-queens)))
  (is (= 352 (n-queens 9))))
