(ns basicljs.chrome-test
  (:require  [clojure.test :refer [deftest]]
             [clj-chrome-devtools.cljs.test :refer [build-and-test]]))

(deftest run-chrome-test
  (try
    (build-and-test "test"
                    '[basicljs.core-test])
    (catch Exception e
      (str "Exception in test: " (.getMessage e)))))
