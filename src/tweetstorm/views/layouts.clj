(ns tweetstorm.views.layouts
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5)]))


(defn common [title & body]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:title title]
    [:body
     [:div {:id "header"}
      [:h1 "STUFF"]]
     [:div {:id "content"} body]]]))

(defn four-oh-four []
  common "Page not found"
  [:div {:id "four-oh-four"}
         "The page you're looking for cannot be found."])
