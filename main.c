#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>


int main(int argc, char* argv[]) {

	FILE* input_file = NULL;
	FILE* output_file = NULL;

	printf("Let's do this\n");

	if(argc <= 1) {

		printf("No arguments");
		exit(1);

	}

	input_file = fopen(argv[1], "r");

	

	return 0;

}
