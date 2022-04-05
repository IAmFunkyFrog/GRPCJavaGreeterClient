package com.homework;

import com.google.protobuf.BlockingRpcChannel;
import com.homework.RPC.GreeterGrpc;
import com.homework.RPC.HelloReply;
import com.homework.RPC.HelloRequest;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class Main {

    public static void main(String[] args) {
        Channel channel = ManagedChannelBuilder.forAddress("0:0:0:0:0:0:0:0", 8081).usePlaintext().build();
        GreeterGrpc.GreeterBlockingStub greeter = GreeterGrpc.newBlockingStub(channel);
        HelloRequest request = HelloRequest.newBuilder()
                .setName("OtherName")
                .build();
        HelloReply reply = greeter.sayHello(request);
        System.out.println(reply.getMessage());
    }
}
