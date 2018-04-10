package com.ch.web.other;

/**
 * @author cj-ch
 * @date 2018/4/2 下午6:12
 */
public class Receiver {
    /**
     * 命令接收者知道具体如何处理业务
     */
    public void action(){
        System.out.println("真正的业务逻辑处理...");
    }


    /**
     * 抽象命令接口
     */
    interface Command{
        void execute();
    }

    /**
     * 命令实现
     */
    public class CommandImplement implements Command{

        private Receiver receiver;

        public CommandImplement(Receiver receiver){
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.action();
        }
    }

    /**
     * 命令调用者
     *
     */
    public class Invoker{
        private Command command;
        public Invoker(Command command){
            this.command = command;
        }

        public void action(){
            this.command.execute();
        }
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = receiver.new CommandImplement(receiver);
        Invoker invoker = receiver.new Invoker(command);
        //客户端通过调用者来执行命令
        invoker.action();
    }
}
