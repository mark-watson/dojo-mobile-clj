(ns dojo-mobile-clj.views.index
  (:require [dojo-mobile-clj.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/111" []
  (common/layout
    (common/dojo-view
      "id1"
      (common/h3 "Welcome to dojo-mobile-clj")
        (common/select "selid1" [["1" "1 person"] ["2" "2 people" true] ["3" "3 people"]]) )))


(defpage "/" []
  (common/layout
    (common/dojo-view
      "id1"
      (common/h3 "Welcome to dojo-mobile-clj")
      (common/round-rect
         "header_id"
         (common/input "input1" "40" "Enter query")
         "&nbsp;&nbsp;&nbsp;Select number served:"
         (common/select "select1" [["1" "1 person"] ["2" "2 people" true] ["3" "3 people"]]))
      (common/round-rect
         "rcontent"
        [:div "Placeholder text"]))))

(defpage [:get "/ajax"] {:as ajax-info}
  (println (str "/ajax " ajax-info))
  (str "Testing AJAX. query text: " (:query ajax-info) " selection: " (:selection ajax-info)))

