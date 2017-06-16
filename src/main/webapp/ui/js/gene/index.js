$(function() {

	// 选项卡
	var mainTabs = $('#mainTabs');

	// Tree Node OnClick
	var nodeClick = function(node) {
		if (node.attributes.url) {
			var src = node.attributes.url;
			if (!sy.startWith(node.attributes.url, '/')) {
				src = node.attributes.url;
			}
			var opts = {
				title : node.text,
				closable : true,
				iconCls : node.iconCls,
				content : sy
						.formatString(
								'<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>',
								src),
				border : false,
				fit : true
			};
			if (mainTabs.tabs('exists', opts.title)) {
				mainTabs.tabs('select', opts.title);
			} else {
				mainTabs.tabs('add', opts);
			}
		}
	};

	// JS加载菜单导航
	<% for(menu in menuList){ %>
	$('#${menu.id}').tree({
			url : '/home/getSubMenu/${menu.id}',
			animate : true,
			onClick : nodeClick
	});
	<%}%>

	// 选项卡菜单
	var tabsMenu = $('#tabsMenu').menu({
		onClick : function(item) {
			var curTabTitle = $(this).data('tabTitle');
			var type = $(item.target).attr('type');

			if (type === 'close') {
				var t = mainTabs.tabs('getTab', curTabTitle);
				if (t.panel('options').closable) {
					mainTabs.tabs('close', curTabTitle);
				}
				return;
			}

			var allTabs = mainTabs.tabs('tabs');
			var closeTabsTitle = [];

			$.each(allTabs, function() {
						var opt = $(this).panel('options');
						if (opt.closable && opt.title != curTabTitle
								&& type === 'closeOther') {
							closeTabsTitle.push(opt.title);
						} else if (opt.closable && type === 'closeAll') {
							closeTabsTitle.push(opt.title);
						}
					});

			for (var i = 0; i < closeTabsTitle.length; i++) {
				mainTabs.tabs('close', closeTabsTitle[i]);
			}
		}
	});
	// 初始化选项卡
	mainTabs.tabs({
				fit : true,
				border : false,
				tools : [{
					text : '最大化',
					iconCls : 'icon-arrowoutlonger',
					handler : function() {
						$('#mainLayout').layout("collapse", "north").layout(
								"collapse", "west");
					}
				}, {
					text : '刷新',
					iconCls : 'icon-arrowrefresh',
					handler : function() {
						var panel = mainTabs.tabs('getSelected').panel('panel');
						var frame = panel.find('iframe');
						try {
							if (frame.length > 0) {
								for (var i = 0; i < frame.length; i++) {
									frame[i].contentWindow.document.write('');
									frame[i].contentWindow.close();
									frame[i].src = frame[i].src;
								}
								if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
									try {
										CollectGarbage();
									} catch (e) {
									}
								}
							}
						} catch (e) {
						}
					}
				}],
				onContextMenu : function(e, title) {
					e.preventDefault();
					tabsMenu.menu('show', {
								left : e.pageX,
								top : e.pageY
							}).data('tabTitle', title);
				}
			});
	// 初始化添加默认主页
	var mainOpts = {
		fit : true,
		title : '首页',
		closable : false,
		border : false,
		iconCls : 'icon-feed',
		content : '<iframe id="mainFrame" name="mainFrame" src="/toProtal" allowTransparency="true" style="border: 0; width: 100%; height: 99%;" frameBorder="0"></iframe>'
	};
	mainTabs.tabs('add', mainOpts);
});