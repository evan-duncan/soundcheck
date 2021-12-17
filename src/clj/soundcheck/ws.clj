(ns soundcheck.ws
  (:require
   [luminus.ws :as ws]
   [clojure.tools.logging :as log]))

(defn on-connect [ws]
  (log/info "WS Connect" ws))

(defn on-error [ws e]
  (log/info "WS Error" e))

(defn on-text [ws text]
  (log/info "Text: text")
  (ws/send! ws text))

(defn on-close [ws status-code reason]
  (log/info "WS Close" reason))

(defn on-bytes [ws bytes offset len]
  (log/info "WS bytes" bytes))

(def handler
  {:context-path "/ws"
   :allow-null-path-info? false
   :on-connect on-connect
   :on-error on-error
   :on-text on-text
   :on-close on-close
   :on-bytes on-bytes})
