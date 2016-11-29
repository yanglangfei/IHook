package com.yf.ihook.model;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public class Face {
    /**
     * face : [{"position":{"mouth_right":{"y":37.099333,"x":62.01087},"mouth_left":{"y":37.2945,"x":54.608213},"center":{"y":33.166667,"x":58.695652},"height":13.666667,"width":19.806763,"nose":{"y":34.8305,"x":58.001932},"eye_left":{"y":29.749,"x":52.896377},"eye_right":{"y":29.638333,"x":63.475121}},"attribute":{"race":{"value":"Asian","confidence":99.64150000000001},"gender":{"value":"Female","confidence":99.9812},"smiling":{"value":9.53978},"age":{"value":23,"range":5}},"tag":"","face_id":"6c270037cd561b7b7d86a2f3275de967"}]
     * session_id : c92b3b533f0041f19d6f3bd74a1f4a10
     * img_height : 1375
     * img_width : 950
     * img_id : 22c4cb25683e4cffa804bb90c4dd6f31
     * url : null
     * response_code : 200
     */

    private String session_id;
    private int img_height;
    private int img_width;
    private String img_id;
    private Object url;
    private int response_code;
    private List<FaceBean> face;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public int getImg_height() {
        return img_height;
    }

    public void setImg_height(int img_height) {
        this.img_height = img_height;
    }

    public int getImg_width() {
        return img_width;
    }

    public void setImg_width(int img_width) {
        this.img_width = img_width;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public List<FaceBean> getFace() {
        return face;
    }

    public void setFace(List<FaceBean> face) {
        this.face = face;
    }

    public static class FaceBean {
        /**
         * position : {"mouth_right":{"y":37.099333,"x":62.01087},"mouth_left":{"y":37.2945,"x":54.608213},"center":{"y":33.166667,"x":58.695652},"height":13.666667,"width":19.806763,"nose":{"y":34.8305,"x":58.001932},"eye_left":{"y":29.749,"x":52.896377},"eye_right":{"y":29.638333,"x":63.475121}}
         * attribute : {"race":{"value":"Asian","confidence":99.64150000000001},"gender":{"value":"Female","confidence":99.9812},"smiling":{"value":9.53978},"age":{"value":23,"range":5}}
         * tag :
         * face_id : 6c270037cd561b7b7d86a2f3275de967
         */

        private PositionBean position;
        private AttributeBean attribute;
        private String tag;
        private String face_id;

        public PositionBean getPosition() {
            return position;
        }

        public void setPosition(PositionBean position) {
            this.position = position;
        }

        public AttributeBean getAttribute() {
            return attribute;
        }

        public void setAttribute(AttributeBean attribute) {
            this.attribute = attribute;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getFace_id() {
            return face_id;
        }

        public void setFace_id(String face_id) {
            this.face_id = face_id;
        }

        public static class PositionBean {
            /**
             * mouth_right : {"y":37.099333,"x":62.01087}
             * mouth_left : {"y":37.2945,"x":54.608213}
             * center : {"y":33.166667,"x":58.695652}
             * height : 13.666667
             * width : 19.806763
             * nose : {"y":34.8305,"x":58.001932}
             * eye_left : {"y":29.749,"x":52.896377}
             * eye_right : {"y":29.638333,"x":63.475121}
             */

            private MouthRightBean mouth_right;
            private MouthLeftBean mouth_left;
            private CenterBean center;
            private double height;
            private double width;
            private NoseBean nose;
            private EyeLeftBean eye_left;
            private EyeRightBean eye_right;

            public MouthRightBean getMouth_right() {
                return mouth_right;
            }

            public void setMouth_right(MouthRightBean mouth_right) {
                this.mouth_right = mouth_right;
            }

            public MouthLeftBean getMouth_left() {
                return mouth_left;
            }

            public void setMouth_left(MouthLeftBean mouth_left) {
                this.mouth_left = mouth_left;
            }

            public CenterBean getCenter() {
                return center;
            }

            public void setCenter(CenterBean center) {
                this.center = center;
            }

            public double getHeight() {
                return height;
            }

            public void setHeight(double height) {
                this.height = height;
            }

            public double getWidth() {
                return width;
            }

            public void setWidth(double width) {
                this.width = width;
            }

            public NoseBean getNose() {
                return nose;
            }

            public void setNose(NoseBean nose) {
                this.nose = nose;
            }

            public EyeLeftBean getEye_left() {
                return eye_left;
            }

            public void setEye_left(EyeLeftBean eye_left) {
                this.eye_left = eye_left;
            }

            public EyeRightBean getEye_right() {
                return eye_right;
            }

            public void setEye_right(EyeRightBean eye_right) {
                this.eye_right = eye_right;
            }

            public static class MouthRightBean {
                /**
                 * y : 37.099333
                 * x : 62.01087
                 */

                private double y;
                private double x;

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }

            public static class MouthLeftBean {
                /**
                 * y : 37.2945
                 * x : 54.608213
                 */

                private double y;
                private double x;

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }

            public static class CenterBean {
                /**
                 * y : 33.166667
                 * x : 58.695652
                 */

                private double y;
                private double x;

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }

            public static class NoseBean {
                /**
                 * y : 34.8305
                 * x : 58.001932
                 */

                private double y;
                private double x;

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }

            public static class EyeLeftBean {
                /**
                 * y : 29.749
                 * x : 52.896377
                 */

                private double y;
                private double x;

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }

            public static class EyeRightBean {
                /**
                 * y : 29.638333
                 * x : 63.475121
                 */

                private double y;
                private double x;

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }
            }
        }

        public static class AttributeBean {
            /**
             * race : {"value":"Asian","confidence":99.64150000000001}
             * gender : {"value":"Female","confidence":99.9812}
             * smiling : {"value":9.53978}
             * age : {"value":23,"range":5}
             */

            private RaceBean race;
            private GenderBean gender;
            private SmilingBean smiling;
            private AgeBean age;

            public RaceBean getRace() {
                return race;
            }

            public void setRace(RaceBean race) {
                this.race = race;
            }

            public GenderBean getGender() {
                return gender;
            }

            public void setGender(GenderBean gender) {
                this.gender = gender;
            }

            public SmilingBean getSmiling() {
                return smiling;
            }

            public void setSmiling(SmilingBean smiling) {
                this.smiling = smiling;
            }

            public AgeBean getAge() {
                return age;
            }

            public void setAge(AgeBean age) {
                this.age = age;
            }

            public static class RaceBean {
                /**
                 * value : Asian
                 * confidence : 99.64150000000001
                 */

                private String value;
                private double confidence;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public double getConfidence() {
                    return confidence;
                }

                public void setConfidence(double confidence) {
                    this.confidence = confidence;
                }
            }

            public static class GenderBean {
                /**
                 * value : Female
                 * confidence : 99.9812
                 */

                private String value;
                private double confidence;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public double getConfidence() {
                    return confidence;
                }

                public void setConfidence(double confidence) {
                    this.confidence = confidence;
                }
            }

            public static class SmilingBean {
                /**
                 * value : 9.53978
                 */

                private double value;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }
            }

            public static class AgeBean {
                /**
                 * value : 23
                 * range : 5
                 */

                private int value;
                private int range;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public int getRange() {
                    return range;
                }

                public void setRange(int range) {
                    this.range = range;
                }
            }
        }
    }
}
