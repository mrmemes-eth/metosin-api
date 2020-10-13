(ns {{namespace}}
  (:gen-class)
  (:require [muuntaja.core :as muuntaja]
            [reitit.coercion.malli :as malli-coercion]
            [reitit.ring :as ring]
            [reitit.ring.coercion :as ring-coercion]
            [reitit.ring.middleware.muuntaja :as muuntaja-middleware]
            [ring.adapter.jetty :as jetty]))

(defn add
  [{ {:keys [body]} :parameters}]
  (let [{:keys [x y]} body]
    {:status 200
     :body {:total (+ x y)}}))

(defn echo
  [request]
  {:status 200
   :body (:body-params request)})

(def app (ring/ring-handler
          (ring/router
           [["/echo"
             {:post {:summary "simple example that returns the body encoded with negotiated content type"
                     :handler echo}}]
            ["/add"
             {:post {:summary "coercion example that handles a request to add two numbers"
                     :parameters {:body [:map [:x int?] [:y int?]]}
                     :responses {200 {:body [:map [:total int?]]}}
                     :handler add}}]]

           {:data {:muuntaja muuntaja/instance
                   :coercion malli-coercion/coercion
                   :middleware [muuntaja-middleware/format-middleware
                                ring-coercion/coerce-exceptions-middleware
                                ring-coercion/coerce-request-middleware
                                ring-coercion/coerce-response-middleware]}})))

(defn -main
  "run a server for a simple content-negotiated API app."
  [& _]
  (jetty/run-jetty #'app {:port 3000 :join? false}))
