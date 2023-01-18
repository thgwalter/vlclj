(ns vlclj.core
  (:import [java.awt.event WindowAdapter]
           [javax.swing JFrame SwingUtilities]
           [uk.co.caprica.vlcj.player.component EmbeddedMediaPlayerComponent])
  (:gen-class))


;; SWING BOILERPLATE


(defmacro later [& body]
  `(SwingUtilities/invokeLater (fn [] ~@body)))


(defn window-closing [^JFrame f fun]
  (.addWindowListener f (proxy [WindowAdapter] []
                          (windowClosing [e]
                            (fun e)))))


(defn make-frame [& {:keys [^String title content closing]}]
  (let [f (doto (JFrame.)
            (.setBounds 100 100 640 480))]
    (when title
      (.setTitle f title))
    (when content
      (.setContentPane f content))
    (when closing
      (window-closing f closing))
    f))


;; VLCJ EXAMPLE


(defn play

  [^EmbeddedMediaPlayerComponent player
   ^String media-file-path
   & {options :options}]

  (.. player mediaPlayer media
      (play media-file-path
            (into-array String (concat [] options)))))


(def app (atom {}))


(defn -main [& args]

  (swap! app assoc :player (EmbeddedMediaPlayerComponent.))
  (swap! app assoc :frame (make-frame
                           :title "vlclj"
                           :content (:player @app)
                           :closing (fn [_] (.release (:player @app)))))
  
  (.setDefaultCloseOperation (:frame @app) JFrame/EXIT_ON_CLOSE)

  (later (.setVisible (:frame @app) true)
         (play (:player @app) (first args))))

