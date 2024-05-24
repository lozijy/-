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
					<u--text text="施肥记录" size=16 bold=true></u--text>
					<u-line></u-line>
				</view>
				<view class="Records">
					<u-cell-group>
						<u-cell title="地块：1种类：xx用量：100" value="详细" label="施肥时间：2024/5/20 11:30" isLink url="/pages/componentsB/tag/tag"></u-cell>
						<u-cell title="地块：1种类：xx用量：100" value="详细" label="施肥时间：2024/5/20 11:30" isLink
							url="/pages/componentsB/badge/badge"></u-cell>
					</u-cell-group>
				</view>
			</view>
		</view>
		<view class="buttom-middle">
			<view class="buttom1">
				<u-button class="custom-button"@click="add()">
					<text class="custom-text">添加施肥记录</text>
				</u-button>
			</view>
			<view class="buttom2">
				<u-button class="custom-button"@click="goBack()">
					<text class="custom-text">返回</text>
				</u-button>
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
				src1: '../../static/login/beijing1.png'
			}
		},
		methods: {
		goBack() {
					uni.navigateBack({
						delta: 1 // 这里的数字表示返回的页面层数，1表示返回上一级页面
					});
				},
		add(){
			uni.navigateTo({
				url:'/pages/message/addRecord'
			})
		}
				
				

		}
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
			height: 860rpx;
			background-color: #ffffff;
			box-shadow: 0px 0px 9px 0px rgba(10, 53, 74, 0.19);
			border-radius: 10rpx;
			margin-top: 10rpx;
		}

		.subheading {
			margin-top: 10rpx;
			margin-left: 5rpx;
		}
	}
	.buttom-middle{
		margin-left: 100rpx;
	}

	@import "@/css/system.scss";
</style>