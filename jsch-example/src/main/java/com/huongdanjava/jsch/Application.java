package com.huongdanjava.jsch;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class Application {

    public static void main(String[] args) throws JSchException, SftpException {
        String hostname = "192.168.51.24";
        String login = "khanh";
        String password = "123456";

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");

        JSch ssh = new JSch();
        Session session = ssh.getSession(login, hostname, 22);
        session.setConfig(config);
        session.setPassword(password);
        session.connect();

        ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
        sftp.connect();

        System.err.println(sftp.pwd());

        sftp.disconnect();
        session.disconnect();

    }
}