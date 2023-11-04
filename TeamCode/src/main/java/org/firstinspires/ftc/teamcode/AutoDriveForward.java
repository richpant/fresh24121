package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class AutoDriveForward {
    @Autonomous(name = "AutoForward", group = "Linear Opmode")
//@Disabled
    public class FreshDriveCode extends LinearOpMode {

        // Declare OpMode members for each of the 4 motors.
        private ElapsedTime runtime = new ElapsedTime();
        private DcMotor leftFrontDrive = null;
        private DcMotor leftBackDrive = null;
        private DcMotor rightFrontDrive = null;
        private DcMotor rightBackDrive = null;
        private Servo claw = null;
        private DcMotor lift = null;
        private DcMotor liftrotate = null;
        private Servo clawrotate;

        @Override
        public void runOpMode() {

            // Initialize the hardware variables. Note that the strings used here must correspond
            // to the names assigned during the robot configuration step on the DS or RC devices.
            leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
            leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
            rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
            rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");
            claw = hardwareMap.get(Servo.class, "claw");
            clawrotate = hardwareMap.get(Servo.class, "clawroatatre");
            liftrotate = hardwareMap.get(DcMotor.class, "liftrotate");
            lift = hardwareMap.get(DcMotor.class, "lift");

            // ########################################################################################
            // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
            // ########################################################################################
            // Most robots need the motors on one side to be reversed to drive forward.
            // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft)
            // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
            // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
            // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
            // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward
            // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.
            leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
            leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
            rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
            rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
            claw.setDirection(Servo.Direction.FORWARD);
            clawrotate.setDirection(Servo.Direction.FORWARD);
            liftrotate.setDirection(DcMotor.Direction.FORWARD);
            lift.setDirection(DcMotor.Direction.FORWARD);

            // Wait for the game to start (driver presses PLAY)
            telemetry.addData("Status", "Initialized");
            telemetry.update();

            waitForStart();


            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {
                move(800, 800, 800, 800);
            }

        }


        public void move(int lf, int lb, int rf, int rb) {
            rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            rightFrontDrive.setTargetPosition(rf);
            rightBackDrive.setTargetPosition(rb);
            leftFrontDrive.setTargetPosition(lf);
            leftBackDrive.setTargetPosition(lb);

            rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            rightBackDrive.setPower(0.5);
            rightFrontDrive.setPower(0.5);
            leftFrontDrive.setPower(0.5);
            leftBackDrive.setPower(0.5);

            while (leftFrontDrive.isBusy() && leftBackDrive.isBusy() && rightFrontDrive.isBusy() && rightBackDrive.isBusy()) {
                sleep(25);

            }
            rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            rightBackDrive.setPower(0);
            leftFrontDrive.setPower(0);
            rightFrontDrive.setPower(0);
            leftBackDrive.setPower(0);
        }
    }
}

