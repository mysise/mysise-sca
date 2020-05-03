路由配置
[{
	"filters": [{
		"args": {
			"parts": "2"
		},
		"name": "StripPrefix"
	}],
	"id": "mysise-demo",
	"order": 99,
	"predicates": [{
		"args": {
			"pattern": "/api/demo/**"
		},
		"name": "Path"
	}],
	"uri": "lb://mysise-demo"
},{
	"filters": [{
		"args": {
			"parts": "2"
		},
		"name": "StripPrefix"
	}],
	"id": "mysise-demo1",
	"order": 99,
	"predicates": [{
		"args": {
			"pattern": "/api/demo1/**"
		},
		"name": "Path"
	}],
	"uri": "lb://mysise-demo1"
}]