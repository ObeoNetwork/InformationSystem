App.views.widgets.list = Em.CollectionView.extend({
	content : ["A", "B"], itemViewClass : Ember.View.extend({
		template : Ember.Handlebars.compile("the letter: {{content}}")
	})
}); 


chocos : Em.computed(function() {
			var chocoIds = this.get('chocoIds');
			return App.chocos.set.filter(function(item, index, self) {
				return item.id in chocoIds;
			})
		}).property('chocoIds'), 
		
didInsertElement

msg = "Change a few things up and try submitting again.";
		viewUtil.toast.info(msg);
	
		viewUtil.toast.warning(msg);
		
		viewUtil.toast.success(msg);
		
		viewUtil.toast.danger(msg);