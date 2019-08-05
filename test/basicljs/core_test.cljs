(ns basicljs.core-test
  (:require
    [clojure.test :refer [deftest is]]
    [basicljs.core :as b]))

(deftest simplest-test
  (is true))

(deftest simple-function-test
  (is (= "Hi!" (b/say-hi))))

(defn setupTestData! [doc]
  "Adds to doc's body element a div of the form:
  '<div id=\"testId1\" style=\"color: blue;\">Some content text</div>'
  and also returns the created div element."
  (let [newDiv (.createElement doc "div")]
    (.setAttribute newDiv "id" "testId1")
    (.setAttribute newDiv "style" "color: blue;")
    (set! (.-innerHTML newDiv) "Some content text")
    (.appendChild (.-body doc) newDiv)
    newDiv))


(deftest get-element-by-id-test
  (try
    (let [doc js/document
          newDiv (setupTestData! doc)]
      (is (not (nil? (b/getElementById! "testId1")))))
    (catch js/Error e
      (println "Error in test: " (println e)))))
