(ns basicljs.core)

(defn say-hi []
  "Hi!")

(defn getElementById! [id]
  (do
    (.getElementById js/document id)))
