(ns simplehomepage.core
  (:use [noir.core]
   [noir.request]
   [noir.response :only [redirect]]
   )
  (:require [noir.server :as server]))


(defpage [:get "/"] {:as nopart}
  (redirect "/index.html")
)


(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))
        ]
    (server/start port {:mode mode
                        :ns 'simplehomepage})))