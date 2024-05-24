<template>
	<view class="container">
		<!-- 顶部  图片及标题-->
		<view class="top">
			<u--image :showLoading="true" :src="src1" width="100%" height="80px" @click="click"></u--image>
			<!-- <image src="../../static/login/980.png" mode="widthFix" style="width: 100%;"></image> -->
			<!-- <text class="title" style="color: #ffffff; ">智慧农业系统</text> -->
			<view class="headline">
				<u--text text="xx农田" size=25 color=#ffffff align="center"></u--text>
			</view>
		</view>
		<!--中下部分-->
		<view class="buttom">
			<view class="main">
				<view class="subheading">
					<u--text text="农田信息" size=16 bold=true></u--text>
					<u-line></u-line>
				</view>
				<view class="module1">
					<view class="subheading1">
						<u--text text="环境检查" size=16 color=#0055ff></u--text>
					</view>
					<view class="widget">
						<u-cell v-if="sensor[0]" title='土壤温度' :value="tu_temperature" label="单位：℃"></u-cell>
						<u-cell v-if="sensor[1]" title='土壤湿度' :value="tu_humidity" label="单位：%"></u-cell>
						<u-cell v-if="sensor[2]" title='空气温度' :value="kong_temperature" label="单位：℃"></u-cell>
						<u-cell v-if="sensor[3]" title='空气湿度' :value="kong_humidity" label="单位：%"></u-cell>
					</view>
				</view>
				<view class="module2">
					<view class="subheading2">
						<u--text text="施肥记录" size=16 color=#0055ff></u--text>
					</view>
					<view class="txt1">
						 <u-notice-bar :text="text1"></u-notice-bar>
					</view>
					<view class="buttom1">
						<u-button class="custom-button"@click="fertilizer()">
							<text class="custom-text">施肥记录管理</text>
						</u-button>
					</view>
				</view>
				<view class="module3">
					<view class="subheading3">
						<u--text text="气象检测" size=16 color=#0055ff></u--text>
					</view>
					<view class="buttom2">
						<u-button class="custom-button">
							<text class="custom-text">详细</text>
						</u-button>
					</view>
				</view>
			</view>
		</view>
		<view class="buttom-max">
			<u-tabbar :value="value6" @change="name => value6 = name" :fixed="true" :placeholder="true"
				:safeAreaInsetBottom="true">
				<u-tabbar-item text="信息" icon="more-circle"></u-tabbar-item>
				<u-tabbar-item text="管理" icon="grid"></u-tabbar-item>
				<u-tabbar-item text="我的" icon="account"></u-tabbar-item>
			</u-tabbar>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				src1: '../../static/login/beijing1.png',
				text1:"下次施肥时间：2024/5/20 11:30",
				// kong_temperature:0.01,
				// kong_humidity:0.01,
				// tu_temperature:0.01,
				// tu_humidity:0.01,
			}
		},
		computed:{
			kong_temperature(){return this.$store.state.kong_temperature},
			kong_humidity(){return this.$store.state.kong_humidity},
			tu_temperature(){return this.$store.state.tu_temperature},
			tu_humidity(){return this.$store.state.tu_humidity},
			sensor(){return this.$store.state.sensor}
			
		},
		methods: {
			fertilizer(){

				uni.navigateTo({
					url:'/pages/message/fertilizerManagement'
				})
			},
			modify_sensor(id){
				this.$store.dispatch("modify_sensor",id);
			}
			get_message(data){

				if(data.type=="turang"){
					this.$store.dispatch("get_tu",data);
									// this.$store.dispatch("modify_sensor",0);
				}
				else if(data.type=="kongqi"){
					this.$store.dispatch("get_kong",data);
					console.log(this.$store.state);
				}

			}

		},
watch: {
  kong_temperature(newValue) {
    this.kong_temperature = newValue;
  },
  kong_humidity(newValue) {
    this.kong_humidity = newValue;
  },
  tu_temperature(newValue) {
    this.tu_temperature = newValue;
  },
  tu_humidity(newValue) {
    this.tu_humidity = newValue;
  },
  sensor(newValue){
	  this.sensor = newValue
  }
},
		  mounted() {
		    console.log(1);
		    //自动发送websocket请求
		    this.$root.$socket = new WebSocket(`ws://39.105.164.136:8090/ws/serverTwo`);
		    this.$root.$socket.addEventListener('open', () => {
		      console.log('Connected to server');
		    });
		    this.$root.$socket.addEventListener('message', (event) => {
		      console.log('Received message:', event.data);
			  this.get_message(JSON.parse(event.data));
		    });
		    this.$root.$socket.addEventListener('close', (a) => {
		      console.log('Disconnected from server');
		      console.log(a);
		    });
		  },
	}
</script>

<style scoped lang="scss">
	/* 按钮样式 */
	.custom-button {
		position: relative;
		align-self: center;
		margin: 10px;
		box-shadow: 0rpx 14rpx 34rpx #7033ff33;
		background-image: linear-gradient(89.99999999999999deg, #62ff46 0%, #12ac10 100%);
		border-radius: 16rpx;
		width: 510rpx;
		height: 80rpx;
		text-align: center;
	}

	/* 文本样式 */
	.custom-text {
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		text-transform: uppercase;
		color: #ffffff;
		font-size: 20px;
	}

	.buttom {
		width: 100%;
		display: flex;
		justify-content: center;

		.main {
			position: relative;
			width: 700rpx;
			height: 1050rpx;
			background-color: #ffffff;
			box-shadow: 0px 0px 9px 0px rgba(10, 53, 74, 0.19);
			border-radius: 10rpx;
			margin-top: 10rpx;
		}

		.subheading {
			margin-top: 10rpx;
			margin-left: 5rpx;
		}

		.module1 {

			.subheading1 {
				margin-top: 10rpx;
				margin-left: 270rpx;
			}

			.widget {}


		}

		.module2 {
			.subheading2 {
				margin-top: 10rpx;
				margin-left: 270rpx;
			}

			.txt1 {
				margin-top: 10rpx;
			}

			.buttom1 {
				margin-left: 60rpx;
			}
		}

		.module3 {
			.subheading3 {
				margin-top: 10rpx;
				margin-left: 270rpx;

			}
			.buttom2 {
				margin-left: 60rpx;
			}
		}
	}

	@import "@/css/system.scss";
</style>