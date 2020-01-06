import request from '@/utils/request'

// 登录方法
export function login(username, password) {
  const data = {
    username: username,
    password: password
  }
  return request({
    url: '/sysUser/login',
    method: 'post',
    data: data
  })
}

// 退出方法
export function logout(token) {
  return request({
    url: '/sysUser/logout',
    method: 'post',
    data: {token: token}
  })
}
