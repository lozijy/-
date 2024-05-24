// store/index.js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
  	kong_humidity:0,
  	kong_temperature:0,

	tu_temperature:0,
	tu_humidity:0,
	conductivity:0,
	phValue:0,
	totalNitrogen:0,
	totalPhosphorus:0,
	sensor:[true,true,true,true]
	
  },
  mutations:{
  	//水
		modify_sensor(state,id){
			if(state.sensor[id]==false){state.sensor[id]=true}
			else{state.sensor[id]=false}
		},
  	    get_conductivity(state,conductivity){
  	        state.conductivity=conductivity;
  	    },
  	//空气湿度，温度
  		get_kong_humidity(state,humidity){
  		    state.kong_humidity=humidity;
  		},
  		get_kong_temperature(state,temperature){
  		    state.kong_temperature=temperature;
  		},
		get_tu_humidity(state,humidity){
		    state.tu_humidity=humidity;
		},
		get_tu_temperature(state,temperature){
		    state.tu_temperature=temperature;
		},
  },
  actions:{
  	//空气
  	get_kong(context,data){
  		context.commit("get_kong_humidity",data.humidity);
  		context.commit("get_kong_temperature",data.temperature);
  	},
	get_tu(context,data){
		context.commit("get_tu_humidity",data.humidity);
		context.commit("get_tu_temperature",data.temperature);
	},
	modify_sensor(context,id){
		context.commit("modify_sensor",id);
	},
  }
})


