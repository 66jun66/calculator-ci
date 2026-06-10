#!/bin/bash
echo "================================"
echo "  Building Calculator Project"
echo "================================"

# Set up directories
BUILD_DIR="build"
rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR

# Compile source
echo ""
echo "[1/3] Compiling source..."
javac -d $BUILD_DIR src/Calculator.java
if [ $? -ne 0 ]; then
    echo "BUILD FAILED: Source compilation error"
    exit 1
fi
echo "  Source compiled OK"

# Compile tests
echo ""
echo "[2/3] Compiling tests..."
javac -cp $BUILD_DIR -d $BUILD_DIR test/CalculatorTest.java
if [ $? -ne 0 ]; then
    echo "BUILD FAILED: Test compilation error"
    exit 1
fi
echo "  Tests compiled OK"

# Run tests
echo ""
echo "[3/3] Running tests..."
echo ""
java -cp $BUILD_DIR CalculatorTest
TEST_RESULT=$?

echo ""
if [ $TEST_RESULT -eq 0 ]; then
    echo "================================"
    echo "  BUILD SUCCESS - All tests pass"
    echo "================================"
else
    echo "================================"
    echo "  BUILD FAILED - Tests failed"
    echo "================================"
    exit 1
fi
