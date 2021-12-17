(ns soundcheck.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [soundcheck.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[soundcheck started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[soundcheck has shut down successfully]=-"))
   :middleware wrap-dev})
