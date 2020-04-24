(defproject burp-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [net.portswigger.burp.extender/burp-extender-api "2.1"]
                 [com.cemerick/pomegranate "1.1.0"]
                 [org.tcrawley/dynapath "1.1.0"] ;; dynamic class loader
                 [camel-snake-kebab "0.4.1"]
                 [cider/cider-nrepl "0.25.0-alpha1"]
                 [seesaw "1.5.0"]
                 [buddy/buddy-core "1.6.0"]
                 [nrepl "0.7.0"]]
  :java-source-paths ["java-src"]
  :source-paths ["src"]
  ;; :omit-source true
  :aot :all
  )
