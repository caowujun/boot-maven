INSERT INTO robin.`role`
(id, parentid, title, description, status, sortindex, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b16b-ffdb6a68ae42', 'root', '管理员', '管理员', 1, 1, NULL, NULL, NULL, NULL);

INSERT INTO robin.sysuser
(id, username, userpsd, cnname, phonenum, status, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b16b-ffdb6a68ae91', 'admin', '96e79218965eb72c92a549dd5a330112', '管理员', '11111111', 1, '2021-03-04 11:50:11', NULL, NULL, NULL);

INSERT INTO robin.roleuser
(id, roleid, userid, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b16b-ffdb1a68ae42', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b16b-ffdb6a68ae91', NULL, NULL, NULL, NULL);



INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae21', 'root', '个人工具', '', 1, 1, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae22', 'root', '系统配置', '', 1, 2, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae23', 'root', '权限管理', '', 1, 3, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae24', '1fa65854-92aa-42a9-b86b-ffdb6a68ae21', '油费统计', '/gasoline', 1, 11, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae25', '1fa65854-92aa-42a9-b86b-ffdb6a68ae21', '个人消费', '/money', 1, 12, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae26', '1fa65854-92aa-42a9-b86b-ffdb6a68ae21', '运动记录', '/fire', 1, 13, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae27', '1fa65854-92aa-42a9-b86b-ffdb6a68ae22', '枚举设置', '/enumtype', 1, 21, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae28', '1fa65854-92aa-42a9-b86b-ffdb6a68ae22', '网站设置', '/customconfig', 1, 22, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae29', '1fa65854-92aa-42a9-b86b-ffdb6a68ae23', '菜单管理', '/menu', 1, 31, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae30', '1fa65854-92aa-42a9-b86b-ffdb6a68ae23', '角色管理', '/role', 1, 32, 'setting', NULL, NULL, NULL, NULL);
INSERT INTO robin.menu
(id, parentid, title, actionurl, status, sortindex, icon, createat, createby, updateat, updateby)
VALUES('1fa65854-92aa-42a9-b86b-ffdb6a68ae31', '1fa65854-92aa-42a9-b86b-ffdb6a68ae23', '用户管理', '/sysuser', 1, 33, 'setting', NULL, NULL, NULL, NULL);


INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('1', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae21', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('10', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae30', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('11', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae31', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('2', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae22', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('3', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae23', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('4', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae24', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('5', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae25', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('6', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae26', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('7', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae27', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('8', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae28', NULL, NULL, NULL, NULL);
INSERT INTO robin.rolemenu
(id, roleid, menuid, createat, createby, updateat, updateby)
VALUES('9', '1fa65854-92aa-42a9-b16b-ffdb6a68ae42', '1fa65854-92aa-42a9-b86b-ffdb6a68ae29', NULL, NULL, NULL, NULL);


