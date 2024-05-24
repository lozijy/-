<template>
	<view class="container">
		<!-- 顶部  图片及标题-->
		<view class="top">
			<u--image src="../../static/login/980.png" width="100%" height="300px"></u--image>
			<!-- <image src="../../static/login/980.png" mode="widthFix" style="width: 100%;"></image> -->
			<!-- <text class="title" style="color: #ffffff; ">智慧农业系统</text> -->
			<view class="headline">
				<u--text type="primary" text="智慧农业系统" size=30 align="center"></u--text>
			</view>
		</view>
		<!--中下  -->
		<view class="buttom">
			<!-- 中间圆框-->
			<view class="main">
				<!--文本：找回密码-->
				<view class="mimatext">
					<view>
						找回密码
					</view>
				</view>
				<!-- 输入框及按钮-->
				<view class="operation">
					<!--输入框背景 -->
					<view class="items">
						<u--input placeholder="请输入用户名" border="none" v-model="user.username" prefixIcon="search"
							prefixIconStyle="font-size: 22px;color: #909399"></u--input>
						<!-- <image src="../../static/login/denglu.png" mode="widthFix"
							style="width: 40rpx;margin-right:16rpx ;"></image>
						<input class="uni-input" focus placeholder="请输入用户名" v-model="user.username" /> -->
					</view>
					<!-- <u-button text="月落" :style="{boxShadow: '0rpx 14rpx 34rpx #7033ff33',
					    backgroundImage: 'linear-gradient(89.99999999999999deg, #55aaff 0%, #5a54ff 100%)',
					    borderRadius: '16rpx',width: '510rpx',height: '96rpx',textAlign: 'center'}"></u-button>
					<u-button class="flex-col justify-start button section_2" @click="getpro()">
						<u-text class="font text_4 text_12 pos_3">确认</u-text></u-button> -->

					<u-button class="custom-button" @click="getpro()">
						<text class="custom-text">确认</text>
					</u-button>

					<!-- <view class="flex-col justify-start button section_2" @click="getpro()">
						<text class="font text_4 text_12 pos_3">确认</text>
					</view> -->
					<u-button class="custom-button" @click="getback()">
						<text class="custom-text">返回登录</text>
					</u-button>
					<!-- <view class="flex-col justify-start button section_2" @click="goback()">
						<text class="font text_4 text_12 pos_3">返回登录</text>
					</view> -->
				</view>

			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user: {
					username: '',
				},
			};
		},
		// onShow() {
		// 	const value = uni.getStorageSync("user")
		// 	this.user = value
		// 	console.log(value)
		// },
		methods: {
			//切换登录or注册
			getpro() {
				uni.request({
					//请求失败： http://127.0.0.1:4523/m1/4449912-4095843-default/forget?apifoxResponseId=446166497
					url: "http://127.0.0.1:4523/m1/4449912-4095843-default/forget",
					data: this.user,
					method: 'POST',
					success: (res) => {
						console.log(res.data)
						//if(res.data.code*1 == 200){
						if (res.data.status == 1) {
							//const value = res.data.data
							//this.user = value
							uni.navigateTo({
								url: '/pages/forget/question'
							})
						} else {
							// toast.success('yhmcw')
							this.$u.toast('用户名错误')

						}
					}
				})

			},
			goback() {
				uni.navigateTo({
					url: '/pages/login/login'
				})
			}
		}
	}
</script>

<style scoped lang="scss">
	.buttom {
		width: 100%;
		display: flex;
		justify-content: center;

		.main {
			position: relative;
			width: 670rpx;
			height: 500rpx;
			background-color: #ffffff;
			box-shadow: 0px 0px 9px 0px rgba(10, 53, 74, 0.19);
			border-radius: 40rpx;
			margin-top: -150rpx;
		}
	}

	.mimatext {
		width: 100%;
		padding: 39rpx;
		display: flex;
		align-items: center;
	}

	/* 按钮样式 */
	.custom-button {
		position: relative;
		align-self: center;
		margin: 10px;
		box-shadow: 0rpx 14rpx 34rpx #7033ff33;
		background-image: linear-gradient(89.99999999999999deg, #55aaff 0%, #5a54ff 100%);
		border-radius: 16rpx;
		width: 510rpx;
		height: 96rpx;
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

	// .button {
	// 	position: relative;
	// 	align-self: center;
	// 	margin: 10px;
	// }

	// .section_2 {
	// 	box-shadow: 0rpx 14rpx 34rpx #7033ff33;
	// 	background-image: linear-gradient(89.99999999999999deg, #55aaff 0%, #5a54ff 100%);
	// 	border-radius: 16rpx;
	// 	width: 510rpx;
	// 	height: 96rpx;
	// 	text-align: center;
	// }

	// .pos_3 {
	// 	position: absolute;
	// 	left: 50%;
	// 	top: 50%;
	// 	transform: translate(-50%, -50%);
	// }

	// .text_4 {
	// 	text-transform: uppercase;
	// }

	// .text_12 {
	// 	color: #ffffff;
	// }

	@import "@/css/system.scss";
</style>