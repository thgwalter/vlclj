(defproject vlclj "0.1.0"
  :description "Example project to integrate the VLC Media Player with Swing & Clojure"
  :url "https://github.com/thgwalter/vlclj"
  :license {:name "GPL 3.0 or later with classpath exception"
            :url "https://www.gnu.org/software/classpath/license.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
		 [uk.co.caprica/vlcj "4.8.2"]]
  :main ^:skip-aot vlclj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
