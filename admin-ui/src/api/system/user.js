import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";

// 获取用户详细信息
export function getInfo(token) {
  return request({
    url: '/sysUser/getInfo',
    method: 'get',
    params: { token }
  })
}

// 修改密码
export function updatePwd(oldPwd, newPwd) {
  const data = {
    oldPwd: oldPwd,
    newPwd: newPwd
  }
  return request({
    url: '/sysUser/updatePwd',
    method: 'put',
    data: data
  })
}
