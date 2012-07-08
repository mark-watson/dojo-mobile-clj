(ns dojo-mobile-clj.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "dojo-mobile-clj"]
               [:meta {:name "viewport" :content "width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no"}]
               [:meta {:name "apple-mobile-web-app-capable" :content "yes"}]
                "<script src='http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojo/dojo.js'
	                      data-dojo-config='async:false'></script>
 	               <script language='javascript'>
 	                 require(['dojox/mobile/parser', 'dojox/mobile/deviceTheme', 'dojox/mobile/compat', 'dojox/mobile', 'dojox/mobile/TextBox'],
	                 function(parser, deviceTheme) {
	                  parser.parse();
	                 }
	               );</script>"
                ;; This is crude:just putting some sample Javascript for AJAX here:
                "<script language='javascript'>
                   function ajax_helper() {
		                 dojo.xhrGet({
		                   url: '/ajax?query=' + dojo.byId('input1').value + '&selection=' + dojo.byId('select1').value,
		                   handleAs:'text',
		                   timeout: 8000, // 8 seconds
		                   load: function(data, ioArgs) {
			                          dojo.byId('rcontent').innerHTML = data;
		                         },
		                   error: function(err, ioArgs) {
		                            dojo.byId('rcontent').innerHTML = 'An unexpected error occurred: ' + err;
		                          }
		                 });
	                 }
                   dojo.connect(dojo.byId('input1'), 'onchange', ajax_helper);
                </script>"]
              [:body
               [:div#wrapper
                content]]))

(defpartial dojo-view [id & content]
  [:div {:id id, :data-dojo-type "dojox.mobile.View"}
     content
  ]
)

(defpartial h3 [& content]
  [:div
    "<h3 data-dojo-type='dojox.mobile.Heading'>"
    content
    "</h3>"])

(defpartial select [id items] ; each element in items looks like ["1" "1 person"] or ["1" "1 person" true] for selected
    "<select name='" id "' id='" id "'>"
    (for [item items]
      (if (= (count item) 3)
        (str "<option value='" (first item) "' selected='selected'>" (second item) "</option>")
        (str "<option value='" (first item) "'>" (second item) "</option>")))
    "</select>")

(defpartial round-rect [id & content]
   (println id) (println content)
   "<div id='" id "' data-dojo-type='dojox.mobile.RoundRect' data-dojo-props='shadow:true'>"
   content
   "</div>")

(defpartial input [id size placeholder-text]
  "<input id='" id "' name='" id "' size='" size "' data-dojo-type='dojox.mobile.TextBox' placeHolder='" placeholder-text "'/>")









