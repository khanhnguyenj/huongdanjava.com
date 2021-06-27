$(document).ready(function() {
	alert("Hello WebJars!");
});

var View = Backbone.View.extend({
	initialize: function() {
		alert("Hello In Backbone View");
	}
})
var view = new View({});