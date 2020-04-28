(ns burp-clj.core
  (:require [burp-clj.extender :as extender]
            [burp-clj.nrepl :as nrepl]
            [burp-clj.ui :as ui]
            [burp-clj.version :as version]
            [burp-clj.helper :as helper]
            [burp-clj.cyber-chef :as cyber-chef]
            [burp-clj.shiro-check :as shiro-check]
            [burp-clj.utils :as utils]
            [taoensso.timbre :as log]
            )
  (:gen-class)
  )

(defn logger
  [data]
  (let [{:keys [output_ level error-level?]} data
        formatted-output-str (-> (force output_)
                                 (str "\n"))]
    (if error-level?
      (helper/alert formatted-output-str)
      (helper/log formatted-output-str))))


;;; 必须存在，extension加载时执行
(defn register
  "注册回调"
  [cbs]
  (.setExtensionName cbs "Clojure Plugin")
  (extender/set! cbs)
  (utils/log-time-format!)

  (utils/log-to-fn! :plugin-log logger)

  (log/info :register "register clojure plugin version: " (version/get-version))
  (when (extender/get-setting :nrepl/start-on-load)
    (nrepl/start-nrepl))
  (extender/add-tab! "Clojure Plugin" (ui/make-view))

  (log/info :register "ok!"))


(comment
  (extender/register-context-menu-factory! :cyber-chef (cyber-chef/cyber-chef-menu))

  (extender/remove-context-menu-factory! :cyber-chef )

  (extender/register-proxy-listener! :shiro-check (shiro-check/shiro-check-proxy))

  (extender/remove-proxy-listener! :shiro-check)

  (def tab (ui/make-view))

  )
