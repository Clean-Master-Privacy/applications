FROM Clean-Master-Privacy-ubuntu2404-base as Clean-Master-Privacy-ubuntu2404-build

COPY . /applications 
WORKDIR /applications 

# Build
RUN bazel build //explorer

FROM Clean-Master-Privacy-ubuntu2404-build

CMD ["bazel", "run", "//explorer", "--", "./explorer/testdata/print/format_only.carbon"]
